package druidsurv.cards.monkeys;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.powers.Reload;

import static druidsurv.ModFile.makeID;

public class CrossbowMonkey extends AbstractEasyCard {
    public final static String ID = makeID("Crossbow");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public CrossbowMonkey() {
        super(ID, 2, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY, "CrossbowMonkey_CardArt");
        baseDamage = 12;
        baseSecondDamage = damage*2;
        tags.add(druidsurv.cards.cardvars.CardTags.DART);
        tags.add(druidsurv.cards.cardvars.CardTags.RELOAD);
        tags.add(druidsurv.cards.cardvars.CardTags.MONKEY);
        this.exhaust = true;
        this.setCardBack(cardSubType.MONKEY);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        //(new DamageAction(m, new DamageInfo(AbstractDungeon.player, damage*2, damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HEAVY));
        //altDmg(m, AbstractGameAction.AttackEffect.SLASH_HEAVY);
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
        addToBot((AbstractGameAction)new ApplyPowerAction(p, p, (AbstractPower)new Reload(p, 1), 1, true, AbstractGameAction.AttackEffect.NONE));
    }

    @Override
    public void upp() {
        upgradeDamage(5);
    }
}