package druidsurv.cards.monkeys;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.actions.AttackDamageAndApplyPowerRandomEnemyAction;

import static druidsurv.ModFile.makeID;

public class SpicyMortarMonkey extends AbstractEasyCard {
    public final static String ID = makeID("SpicyMortar");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public SpicyMortarMonkey() {
        super(ID, 2, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ALL_ENEMY, "BurnyStuff_CardArt");
        baseDamage = 12;
        baseMagicNumber = magicNumber = 1;
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        this.setCardBack(cardSubType.MONKEY);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        addToBot((AbstractGameAction)new AttackDamageAndApplyPowerRandomEnemyAction(this, AbstractGameAction.AttackEffect.FIRE));
        //addToBot((AbstractGameAction)new ApplyPowerAction(m, p, (AbstractPower)new OnFire(m, 9), 9, true, AbstractGameAction.AttackEffect.NONE));
    }

    @Override
    public void upp() {
        upgradeDamage(6);
    }
}