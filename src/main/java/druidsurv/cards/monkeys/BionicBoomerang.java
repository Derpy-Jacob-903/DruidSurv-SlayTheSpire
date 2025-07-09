package druidsurv.cards.monkeys;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.Reload;

import static druidsurv.ModFile.makeID;

public class BionicBoomerang extends AbstractEasyCard {
    public final static String ID = makeID("BionicBoomerang");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public BionicBoomerang() {
        super(ID, 4, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY, "BionicBoomerang_CardArt");
        baseDamage = 12;
        baseMagicNumber = magicNumber = 4;
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        tags.add(druidsurv.cards.cardvars.CardTags.RELOAD);
        this.exhaust = true;
        this.isEthereal = true;
        this.setCardBack(cardSubType.MONKEY);
    }



    public void use(AbstractPlayer p, AbstractMonster m)
    {
        for (int i = 0; i < magicNumber; i++){
            dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
        }
        magicNumber -= 2;
        magicNumber = Math.max(2, magicNumber);
        cost = magicNumber;
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new Reload(p, 1), 1, true, AbstractGameAction.AttackEffect.NONE));
    }

    public void triggerOnExhaust() {
        AbstractPlayer p = AbstractDungeon.player;
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new Reload(p, 1), 1, true, AbstractGameAction.AttackEffect.NONE));
    }

    @Override
    public void upp() {
        upgradeDamage(3);
    }
}