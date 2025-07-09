package druidsurv.cards.monkeys.magick;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.orbs.mox.MoxOrb;

import java.util.Objects;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.p;

public class GreenMage extends AbstractEasyCard {
    public final static String ID = makeID("GreenMage");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public GreenMage() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY, CharacterFile.Enums.NEMDRUID_COLOR, "GreenMage_CardArt");
        this.baseDamage = 6;
        this.baseMagicNumber = 3;
        //tags.add(CardTags.STRIKE);
        //tags.add(CardTags.STARTER_STRIKE);
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        setOrbTexture("druidsurvResources/images/512/g_mox.png", "druidsurvResources/images/1024/g_mox.png");
        setBackgroundTexture("druidsurvResources/images/512/monkey_attack.png", "druidsurvResources/images/1024/monkey_attack.png");
    }
    @Override
    public boolean canPlay(AbstractCard card) {
        AbstractEasyCard me = this;
        boolean hasMyMox = false;
        for (int i = 0; i < p().orbs.size(); i++) {
            if (p().orbs.get(i) instanceof MoxOrb)
            {
                if (((MoxOrb)p().orbs.get(i)).GreenAmount > 0)
                {
                    hasMyMox = true;
                }
                if (((MoxOrb)p().orbs.get(i)).RainAmount > 0)
                {
                    hasMyMox = true;
                }
            }
        }
        if (Objects.equals(card.cardID, this.cardID) ) { return hasMyMox && super.canPlay(card); }
        return super.canPlay(card);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        //atb(new ApplyPowerAction(p, p, new GreenMox(p, 1), 1));
        dmg(m, AbstractGameAction.AttackEffect.SLASH_DIAGONAL);
    }

    public static int countCards() {
        int count = 0;
        for (int i = 0; i < p().orbs.size(); i++) {
            if (p().orbs.get(i) instanceof MoxOrb)
            {
                if (((MoxOrb)p().orbs.get(i)).GreenAmount > 0)
                {
                    count += ((MoxOrb)p().orbs.get(i)).GreenAmount;
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
        /*  70 */     int realBaseDamage = this.baseDamage;
        /*  71 */     this.baseDamage += this.magicNumber * countCards();
        /*  73 */     super.calculateCardDamage(mo);
        /*  75 */     this.baseDamage = realBaseDamage;
        /*  78 */     this.isDamageModified = (this.damage != this.baseDamage);
        /*     */   }
    /*     */   public void applyPowers() {
        /*  85 */     int realBaseDamage = this.baseDamage;
        /*  86 */     this.baseDamage += this.magicNumber * countCards();
        /*  88 */     super.applyPowers();
        /*  90 */     this.baseDamage = realBaseDamage;
        /*  93 */     this.isDamageModified = (this.damage != this.baseDamage);
        /*     */   }
    @Override
    public void upp() {
        upgradeDamage(3); upgradeMagicNumber(1);
    }
}