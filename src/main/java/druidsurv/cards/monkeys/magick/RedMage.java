package druidsurv.cards.monkeys.magick;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.orbs.mox.MoxOrb;

import java.util.Objects;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.p;

public class RedMage extends AbstractEasyCard {
    public final static String ID = makeID("RedMage");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public RedMage() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY, CharacterFile.Enums.NEMDRUID_COLOR, "WallOfFireMonkey_CardArt");
        this.baseDamage = 6;
        this.baseMagicNumber = 3;
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        this.setCardBack(cardSubType.MONKEY);
        setOrbTexture("druidsurvResources/images/512/r_mox.png", "druidsurvResources/images/1024/r_mox.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
    }

    @Override
    public boolean canPlay(AbstractCard card) {
        AbstractEasyCard me = this;
        boolean hasMyMox = false;
        for (int i = 0; i < p().orbs.size(); i++) {
            if (p().orbs.get(i) instanceof MoxOrb)
            {
                if (((MoxOrb)p().orbs.get(i)).RubyAmount > 0)
                {
                    hasMyMox = true;
                }
            }
        }
        if (Objects.equals(card.cardID, this.cardID) ) { return hasMyMox && super.canPlay(card); }
        return super.canPlay(card);
    }
    public static int countCards() {
        int count = 0;
        for (int i = 0; i < p().orbs.size(); i++) {
            if (p().orbs.get(i) instanceof MoxOrb)
            {
                if (((MoxOrb)p().orbs.get(i)).RubyAmount > 0)
                {
                    count += ((MoxOrb)p().orbs.get(i)).RubyAmount;
                }
                if (((MoxOrb)p().orbs.get(i)).RainAmount > 0)
                {
                    count += ((MoxOrb)p().orbs.get(i)).RainAmount;
                }
            }
        }
        return count;
        }
    public void calculateCardDamage(AbstractMonster mo) {
        /*  70 */     int realBaseDamage = this.baseBlock;
        /*  71 */     this.baseBlock += this.magicNumber * countCards();
        /*  73 */     super.calculateCardDamage(mo);
        /*  75 */     this.baseBlock = realBaseDamage;
        /*  78 */     this.isBlockModified = (this.block != this.baseBlock);
        /*     */   }
    /*     */   public void applyPowers() {
        /*  85 */     int realBaseDamage = this.baseBlock;
        /*  86 */     this.baseBlock += this.magicNumber * countCards();
        /*  88 */     super.applyPowers();
        /*  90 */     this.baseBlock = realBaseDamage;
        /*  93 */     this.isBlockModified = (this.block != this.baseBlock);
        /*     */   }
    @Override
    public void upp() {
        upgradeDamage(3); upgradeMagicNumber(1);
    }
}